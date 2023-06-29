import React from "react";
import {Link} from "react-router-dom";

const BookCollectionTable = ({bookData, onDeleteBookFromCollection, setBookData}) => {
  return(
      <>
          <nav>
              <div className={"btn-div-for-login-and-register"}>
                  <ul>
                      <li>
                          <Link to="/createBook">
                              <button
                                  className={"btn-left"}
                                  type="button">
                                    Create
                              </button>
                          </Link>
                      </li>
                      <li>
                          <Link to="/">
                              <button className={"btn-left"} type="button">Logout</button>
                          </Link>
                      </li>
                  </ul>
              </div>
          </nav>
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
                              {bookData.map((book, index) => (
                                  <tr key={index}>
                                      <td>{book.title}</td>
                                      <td>{book.author}</td>
                                      <td>{book.genresList}</td>
                                      <td>
                                          <button type={"button"} onClick={() => {
                                              onDeleteBookFromCollection(book.id)}
                                          }>
                                              Delete
                                          </button>
                                      </td>
                                  </tr>
                              ))}
                              </>
                              :
                              null
                      }
                  </tbody>
              </table>
          </div>
      </>
  );
};

export default BookCollectionTable;