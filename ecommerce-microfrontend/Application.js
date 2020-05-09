import './portal/Layout.js';
import './portal/CatalogPage.js';
import './portal/CartPage.js';
import './portal/OrderPage.js';

(function application() {
    const appContent = document.querySelector("#content");

    const registeredPages = [];
    let firstLoaded = false;
        
    function createComponent(path) {
        const reg = registeredPages.find(r => r.matches(path));
        if (reg) {
            firstLoaded = true;
            return reg.component(path);
        }
        return firstLoaded ? document.createTextNode('not found: ' + path) : null;
    }
    function loadComponent(path) {
        const component = createComponent(path);
        if (component) {
            if (appContent.firstChild) {
                appContent.replaceChild(component, appContent.firstChild);
            } else {
                appContent.appendChild(component);
            }
        }
     }
     function navigateTo(href) {
        history.pushState({id: Date.now()}, href, href);
        loadComponent(href);
     }
     function register(matches, component) {
        registeredPages.push({matches, component});
        if (!firstLoaded) {
            loadComponent(window.location.pathname);
        }
     }
     document.addEventListener('click', e => {
        if (e.target.nodeName === 'A') {
            navigateTo(e.target.getAttribute('href'));
            e.preventDefault();
        }
     });
     window.addEventListener('page:nav', ({detail: {href}}) => navigateTo(href));
     window.addEventListener('page:register', ({detail: {matches, component}}) => register(matches, component));

     window.dispatchEvent(new CustomEvent('application:ready'));
})();
