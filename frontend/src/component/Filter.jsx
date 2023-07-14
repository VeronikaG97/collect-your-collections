import React from "react";

const Filter = ({props}) => {
    let thresholdForSearching = 3;
    const handleSearchForTitle = (e) => {
        let userSearch = e.target.value;
        if (userSearch.length <= thresholdForSearching) {
            return;
        }
        return fetch(`http://localhost:8080/collections/books//search/${userSearch}`)
            .then((result) => {
                let data = result.json()
                props.setBookData(data);
            });
    }

  return(
      <div>
          <input placeholder={"search your title"} onChange={handleSearchForTitle}/>
      </div>
  );
}

export default Filter;