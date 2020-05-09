import './portal/Layout.js';
import './portal/CatalogPage.js';
import './portal/CartPage.js';
import './portal/OrderPage.js';

(function application() {
    const appContent = document.querySelector("#content");
        
    function createComponent(href) {
        if (href === '/') {
            return document.createElement('portal-catalog-page');
        }
        if (href.startsWith('/category')) {
            const c = document.createElement('portal-catalog-page');
            c.categoryUri = href.substring(href.lastIndexOf('/') + 1);
            return c;
        }
        if (href.startsWith('/cart')) {
            return document.createElement('portal-cart-page');
        }
        if (href.startsWith('/order')) {
            return document.createElement('portal-order-page');
        }
        return document.createTextNode('not found: ' + href);
    }
    function loadComponent(href) {
        const component = createComponent(href);
        if (appContent.firstChild) {
            appContent.replaceChild(component, appContent.firstChild);
        } else {
            appContent.appendChild(component);
        }
     }
     function navigateTo(href) {
        history.pushState({id: Date.now()}, href, href);
        loadComponent(href);
     }
     document.addEventListener('click', e => {
        if (e.target.nodeName === 'A') {
            navigateTo(e.target.getAttribute('href'));
            e.preventDefault();
        }
     });
     window.addEventListener('page:nav', ({detail: {href}}) => navigateTo(href));
        
     loadComponent(location.pathname);
})();
