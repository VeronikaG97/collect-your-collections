import React from "react";

const Filter = ({props}) => {
    let thresholdForSearching = 3;
    const handleSearchForTitle = async (e) => {
        let userSearch = e.target.value;
        if (userSearch.length <= thresholdForSearching) {
            console.log("NO");
            return;
        }
        let data = await fetch(`http://localhost:8080/collections/books/search/${userSearch}`);
        let result = await data.json();
        console.log(result)
        return props.setBookData(result);
    }

  return(
      <div>
          <input placeholder={"search your title"} onChange={handleSearchForTitle}/>
      </div>
  );
}

export default Filter;