import React from "react";
import {Link} from "react-router-dom";

const BookCollectionTable = ({bookData, onDeleteBookFromCollection, setBookData}) => {
    console.log(bookData)
  return(
      <div className={"item-table"}>
          <h1>Your Book Collection</h1>
          <table>
              <thead>
              <tr>
                  <th>Title</th>
                  <th>Author</th>
                  <th>Genre</th>
              </tr>
              </thead>
              <tbody>
                  {
                      bookData !== null
                        ?
                          <>
                          {bookData.map((book) => (
                              <tr key={book.title}>
                                  <td>{book.title}</td>
                                  <td>{book.author}</td>
                                  <td>{book.genresList}</td>
                              </tr>
                          ))}
                          </>
                          :
                          null
                  }
              </tbody>
          </table>
      </div>
  );
};

export default BookCollectionTable;