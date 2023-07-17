import React, {useEffect, useRef, useState, useCallback} from "react";
import {useNavigate} from "react-router-dom";

//ToDo: Change this to generic form....?
const fetchBookGenres = async () => {
    let genreData = await fetch("http://localhost:8080/collections/books/all-genres");
    return await genreData.json();
}

const onSave = (book) => {
    return fetch("http://localhost:8080/collections/books/add-book", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(book),
    }).then((result) => result.json());
};

const CreateBook = () => {
    const [bookGenres, setBookGenres] = useState();
    const [checkNewBookGenres, setCheckNewBookGenres] = useState([]);


    const refTitle = useRef();
    const refAuthor = useRef();

    const navigate = useNavigate();

    useEffect(() => {
        fetchBookGenres()
            .then((result) => {
                setBookGenres(result)
            });
    }, []);

    const handleSubmit = (e) => {
        e.preventDefault()
        const data = {
            title: refTitle.current?.value,
            creator: refAuthor.current?.value,
            genre: checkNewBookGenres
        }
        onSave(data).then(() => {
            navigate("/logged-in");
        })
    }

    const handleCheckedGenre = (e) => {
        let chosenGenre = e.target.value;
        let isBoxChecked = e.target.checked;
        if(isBoxChecked) {
            setCheckNewBookGenres((checkNewBookGenres) => [
                ...checkNewBookGenres,
                chosenGenre + "; "
            ]);
        } else {
            setCheckNewBookGenres((checkNewBookGenres) =>
                checkNewBookGenres.filter((genre) => genre !== chosenGenre + "; ")
            );
        }
    };

  return(
      <>
          <form onSubmit={handleSubmit}>
              <div>
                  <label htmlFor={"title"} >Title: </label>
                  <input type={"text"} id={"title"} ref={refTitle}/>
              </div>
              <div>
                  <label htmlFor={"author"} >Author: </label>
                  <input type={"text"} id={"author"} ref={refAuthor}/>
              </div>
              {
                  bookGenres != null
                      ?
                      <>
                          {
                              bookGenres.map((genre, index) =>{
                                  return(
                                      <div key={index}>
                                          <label>{genre}</label>
                                          <input
                                              type={"checkbox"}
                                              id={"genre"}
                                              value={genre}
                                              onClick={handleCheckedGenre}
                                          />
                                      </div>
                                  )
                              })}
                      </>
                      :
                      null
              }
              <button type="submit" >Save</button>
          </form>
      </>
  );
}

export default CreateBook;