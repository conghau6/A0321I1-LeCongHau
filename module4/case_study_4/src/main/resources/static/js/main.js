// Show navbar
const showMenu = (headerToggle, navbarId, modalId) => {
    const toggleBtn = document.getElementById(headerToggle),
        nav = document.getElementById(navbarId)
    modal = document.getElementById(modalId)

    // Validate that variables exits
    if(headerToggle && navbarId){
        toggleBtn.addEventListener('click',()=>{
            //add class
            nav.classList.add('show-menu')
            //add modal
            modal.classList.add('nav__show-modal')
            // change icon
            // toggleBtn.classList.toggle('bx-x')
        })

        modal.addEventListener('click',()=>{
            modal.classList.remove('nav__show-modal')
            nav.classList.remove('show-menu')
        })
    }
}
showMenu('header-toggle','navbar','nav__modal')


// link active
const linkColor = document.querySelectorAll('.nav__link')

function colorLink(){
    linkColor.forEach(l => l.classList.remove('active'))
    this.classList.add('active')
}

linkColor.forEach(l=>l.addEventListener('click',colorLink))

// show submenu
const collsape = document.querySelectorAll('.nav__dropdown > .nav__link');
function showSubMenu(){
    (this.parentNode.style.maxHeight == '40px') ? (this.parentNode.style.maxHeight = '100rem') : (this.parentNode.style.maxHeight = '40px');
}

collsape.forEach(l=>l.addEventListener('click',showSubMenu))