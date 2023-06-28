import React, {useEffect, useState} from "react";
import BookCollectionTable from "./BookCollectionTable.jsx";

const fetchBookDataForTable = async () => {
    let fetchData = await fetch("http://localhost:8080/collections/books/all-books");
    let fetchResult = await fetchData.json();
    console.log(fetchResult);
    return fetchResult;
};

const deleteBookFromCollections = async (id) => {
    return fetch(`http://localhost:8080/collections/books/delete-book/${id}`,{ method: "DELETE" })
        .then((res) =>
        res.json()
    );
};

const BookService = () => {
    const [bookData, setBookData] = useState(null);

    const handleDeleteBookFromCollection = (title) => {
      deleteBookFromCollections(title)
          .catch((err) => {
              console.log(err);
          });
        setBookData((items) => {
            return items.filter((collectionItem) => collectionItem.title !== title);
        });
    };

    useEffect(() => {
        fetchBookDataForTable()
            .then((result) => {
                setBookData(result)
            });
    },[])
  return(
      <>
          <BookCollectionTable
              bookData={bookData}
              onDeleteBookFromCollection={handleDeleteBookFromCollection}
              setBookData={setBookData}/>
      </>
  );
};

export default BookService;
