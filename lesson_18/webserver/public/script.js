(() => {
  document.addEventListener("DOMContentLoaded", function () {
    printWelcomeMessage();
    // listenForSearchButtonClick();
  });

  /**
   * Print a welcome message to the console.
   */
  function printWelcomeMessage() {
    console.info("🎉🔥🎉🔥🎉🔥🎉🔥🎉🔥🎉🔥🎉🔥🎉🔥🎉🔥🎉🔥🎉🔥🎉🔥🎉🔥");
    console.info("🔥 Welcome to the Code Differently course! 🎉");
    console.info("🎉🔥🎉🔥🎉🔥🎉🔥🎉🔥🎉🔥🎉🔥🎉🔥🎉🔥🎉🔥🎉🔥🎉🔥🎉🔥");
  }

  /**
   * Adds an event listener to the search button to listen for a click event.
   */
  function listenForSearchButtonClick() {
    document
      .querySelector(".search-button")
      .addEventListener("click", (event) => onSearchButtonClick(event));
  }

  /**
   * Handles the search button click event.
   *
   * @param {Event} event
   */
  function onSearchButtonClick(event) {
    // If this button is inside a form, prevent the form from submitting.
    event.preventDefault();

    // Get the search text from the input field and perform the search.
    const searchText = document.querySelector(".search-text").value;
    performSearch(searchText);
  }

  /**
   * Perform a search for items containing the search text.
   *
   * @param {string} searchText
   */
  async function performSearch(searchText) {
    console.log("Client: Searching for titles containing: ", searchText);
    try {
      const response = await fetch(`http://localhost:5000/items`);
      const data = await response.json();
      const foundItems = data.items.filter((i) =>
        i.title.toLowerCase().includes(searchText.toLowerCase())
      );
      showResults(foundItems);
    } catch (error) {
      console.error(error);
    }
  }

  /**
   * Shows the results on the page.
   *
   * @param {Array} results
   */
  function showResults(results) {
    // Get the results element from the DOM and clear it.
    const resultsEl = document.querySelector(".results");
    resultsEl.innerHTML = "";

    // Create a heading
    const headingEl = document.createElement("h2");
    resultsEl.appendChild(headingEl);
    headingEl.textContent = "Search Results on the Client:";

    // Create an unordered list (UL) element and add it to the results element.
    const ulListEl = document.createElement("ul");
    ulListEl.classList.add("results-list");
    resultsEl.appendChild(ulListEl);

    // Populate the list with the search results using the list item (ul) tag.
    results.forEach((item) => {
      const listItemEl = document.createElement("li");
      listItemEl.textContent = item.title;
      ulListEl.appendChild(listItemEl);
    });
  }
})();
