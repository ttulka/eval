import './portal/CatalogPage.js';
import './portal/CartPage.js';
import './portal/OrderPage.js';

(function application() {
    const appContent = document.querySelector("#content");
        
    function findComponentName(href) {
        if (href === '/' || href.startsWith('/category')) {
            return 'portal-catalog-page';
        }
        if (href.startsWith('/cart')) {
            return 'portal-cart-page';
        }
        if (href.startsWith('/order')) {
            return 'portal-order-page';
        }
    }
    function loadComponent(href) {
        const componentName = findComponentName(href);
        console.debug('Loading component', componentName);
        const component = componentName 
            ? document.createElement(componentName)
            : document.createTextNode('not found: ' + href);
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
