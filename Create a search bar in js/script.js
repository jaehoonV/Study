const userCardTemplate = document.querySelector("[data-user-template]")
const userCardContainer = document.querySelector("[data-user-cards-container]")
const searchInput = document.querySelector("[data-search]")

let users = []

searchInput.addEventListener("input", (e) => { // 입력하는 것에 모두 실행
   const value = e.target.value.toLowerCase() // 소문자, 대문자 구분 X
   users.forEach(user => {
      const isVisible = user.name.toLowerCase().includes(value) || user.email.toLowerCase().includes(value) // 입력값이 name이나 email에 포함돼있다면 true
      user.element.classList.toggle("hide", !isVisible) // false일 경우 hide
   })
})
// 데이터 api 사용 
fetch("https://jsonplaceholder.typicode.com/users")
   .then(res => res.json()) // 응답을 json형식으로 받기
   .then(data => {
      users = data.map(user => {
         const card = userCardTemplate.content.cloneNode(true).children[0] // 첫번째 자식을 가져옴
         const header = card.querySelector("[data-header]")
         const body = card.querySelector("[data-body]")
         header.textContent = user.name
         body.textContent = user.email
         userCardContainer.append(card)
         return { name: user.name, email: user.email, element: card }
      });
   })