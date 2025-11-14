const popup = document.getElementById('popupLogin');
const btnLogin = document.getElementById('btnLogin');
const closeBtn = document.querySelector('.close-btn');

btnLogin.addEventListener('click', () => {
    popup.style.display = 'flex';
});

closeBtn.addEventListener('click', () => {
    popup.style.display = 'none';
});

window.addEventListener('click', (e) => {
    if (e.target === popup) {
        popup.style.display = 'none';
    }
});
