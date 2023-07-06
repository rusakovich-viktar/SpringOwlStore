let dropdowns = document.querySelectorAll('.navbar .dropdown-toggler')

// Handle dropdown menus
if (dropdowns.length) {
    dropdowns.forEach((dropdown) => {
        dropdown.addEventListener('click', (event) => {
            let target = document.querySelector(`#${event.target.dataset.dropdown}`)
            let dropdownIsOpen = false // Объявляем флаг внутри функции

            if (target) {
                if (target.classList.contains('show')) {
                    target.classList.remove('show')
                    dropdownIsOpen = false
                } else {
                    target.classList.add('show')
                    dropdownIsOpen = true
                }
            }
        })
    })
}

// Handle closing dropdowns if a user clicked the body
window.addEventListener('mouseup', (event) => {
    dropdowns.forEach((dropdownButton) => {
        let dropdown = document.querySelector(`#${dropdownButton.dataset.dropdown}`)
        let targetIsDropdown = dropdown == event.target

        if (dropdownButton == event.target) {
            return
        }

        if ((!targetIsDropdown) && (!dropdown.contains(event.target))) {
            dropdown.classList.remove('show')
        }
    })
})

// Open links on mobile devices
function handleSmallScreens() {
    document.querySelector('.navbar-toggler')
        .addEventListener('click', () => {
            let navbarMenu = document.querySelector('.navbar-menu')

            if (!navbarMenu.classList.contains('active')) {
                navbarMenu.classList.add('active')
            } else {
                navbarMenu.classList.remove('active')
            }
        })
}
handleSmallScreens()