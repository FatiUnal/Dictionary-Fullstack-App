const refreshBtn = document.querySelector("#refresh")
refreshBtn.addEventListener("click",getList)

const searchbtn = document.querySelector("#searchbtn")
searchbtn.addEventListener("click",search)

 function search(){
  const search = document.querySelector("#searchInput").value
  fetch(`http://localhost:8080/api/dictionary/search/${search}`)
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then(data => {

      const tabrow = document.querySelector("#tabrow")
      
      tabrow.innerHTML = ""
      var i;
      for (i = 0;i<data.length;i++){

        const firstDiv = document.createElement("div")
        firstDiv.classList.add("col-md-3")
        tabrow.appendChild(firstDiv);


        const secondDiv = document.createElement("div")
        secondDiv.classList.add("card")
        secondDiv.classList.add("border-success")
        secondDiv.classList.add("mb-3")
        secondDiv.classList.add("secondcard")
        firstDiv.appendChild(secondDiv)

        const thirdDiv = document.createElement("div")
        thirdDiv.classList.add("card-header")
        thirdDiv.innerHTML = data[i].englishText
        secondDiv.appendChild(thirdDiv)

        const fourDiv = document.createElement("div")
        fourDiv.classList.add("card-body")
        fourDiv.classList.add("text-success")

        fourDiv.innerHTML = `<h5 class="card-title">${data[i].turkishText}</h5>
        <p class="card-text">${data[i].description} (${data[i].id})</p>`
        secondDiv.appendChild(fourDiv)

      }
      


    })
    .catch(error => {
      console.error('Fetch error:', error);
    });

}


  


function changeText(){
  
  const textId = document.querySelector("#delorchange").value
  const turkishText = document.querySelector("#turkishText").value
    const englishText = document.querySelector("#englishText").value
    const description = document.querySelector("#description").value

    const dictionary = {
      englishText : englishText,
      turkishText : turkishText,
      description : description
  }

  fetch(`http://localhost:8080/api/dictionary/${textId}`,{
        method : "PUT",
        headers : {
            "Content-Type":"application/json"
        },
        body : JSON.stringify(dictionary)
    })
    .then(response => response.json())
    .then(responseData => responseData)
    .catch(error=>{
        console.error("hata: "+error)
    })


    getList();


}

function add(){
    const turkishText = document.querySelector("#turkishText").value
    const englishText = document.querySelector("#englishText").value
    const description = document.querySelector("#description").value
  

    const dictionary = {
        englishText : englishText,
        turkishText : turkishText,
        description : description
    }


    fetch("http://localhost:8080/api/dictionary",{
        method : "POST",
        headers : {
            "Content-Type":"application/json"
        },
        body : JSON.stringify(dictionary)
    })
    .then(response => response.json())
    .then(responseData => responseData)
    .catch(error=>{
        console.error("hata: "+error)
    })

    getList();
}

async function deleteText(){
  
  
  const deleteText = document.querySelector("#delorchange").value;

  fetch(`http://localhost:8080/api/dictionary/${deleteText}`,{
        method : "DELETE",
        headers : {
            "Content-Type":"application/json"
        }
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      console.log('Veri başarıyla silindi.');
      deleteText.value = ""
      getList();
    })
    .then(responseData => responseData)
    .catch(error=>{
        console.error("hata: "+error)
    })

   


    


}


async function getList() {
    
    
    const getList = await fetch("http://localhost:8080/api/dictionary")
      .then((response) => response.json())
      .then((data) => data)
      .catch((error) => {
        console.error("hata: " + error);
      });
  

      const list = getList;
  

      const tabrow = document.querySelector("#tabrow")
      
      tabrow.innerHTML = ""
      var i;
      for (i = 0;i<list.length;i++){

        const firstDiv = document.createElement("div")
        firstDiv.classList.add("col-md-3")
        tabrow.appendChild(firstDiv);


        const secondDiv = document.createElement("div")
        secondDiv.classList.add("card")
        secondDiv.classList.add("border-success")
        secondDiv.classList.add("mb-3")
        secondDiv.classList.add("secondcard")
        firstDiv.appendChild(secondDiv)

        const thirdDiv = document.createElement("div")
        thirdDiv.classList.add("card-header")
        thirdDiv.innerHTML = list[i].englishText
        secondDiv.appendChild(thirdDiv)

        const fourDiv = document.createElement("div")
        fourDiv.classList.add("card-body")
        fourDiv.classList.add("text-success")

        fourDiv.innerHTML = `<h5 class="card-title">${list[i].turkishText}</h5>
        <p class="card-text">${list[i].description} (${list[i].id})</p>`
        secondDiv.appendChild(fourDiv)

      }



      /**
 * 
 * <div class="col-md-3">
          <div class="card border-success mb-3" style="max-width: 18rem;">
            <div class="card-header">Header</div>
            <div class="card-body text-success">
              <h5 class="card-title">Success card title</h5>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            </div>
          </div>
        </div>
 */



  /**
     * 0 : {id: 1, englishText: 'dictionary', turkishText: 'sözlük', description: 'this is a dictionary app'}
       1 : {id: 2, englishText: 'programming language', turkishText: 'programlama dili', description: 'I am using the java programming language'}
       2 : {id: 4, englishText: 'discuss', turkishText: 'Tartışma', description: 'We discuss how to create Java Spring Project'}
       length : 3
   */
  
      
  }




  






