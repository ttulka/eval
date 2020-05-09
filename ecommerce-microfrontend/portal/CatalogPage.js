import '../catalog/ProductList.js';
import '../cart/BuyButton.js';

import catalogService from '../service/catalog.js';
import warehouseService from '../service/warehouse.js';
import cartService from '../service/cart.js';

const template = document.createElement('template');
template.innerHTML = `
    <h1>Product Catalog</h1>
    <catalog-product-list></catalog-product-list>
`;
customElements.define('portal-catalog-page', class extends HTMLElement {
    constructor() {
        super();        
        this._categoryUri = null;
        this._addItemListener = e => {
            this._addItemIntoCart(e.detail)
                .then(_ => window.dispatchEvent(new CustomEvent('page:nav', {detail: {href: '/cart'}})));
            e.preventDefault();
        }
    }
    connectedCallback() {
        console.debug('Catalog page initialized');
        
        this.appendChild(template.content.cloneNode(true));
        this._productList = this.querySelector('catalog-product-list'); 
        
        this._productList.addEventListener('cart:add', this._addItemListener);
                
        this.loadProducts();
    }
    disconnectedCallback() {
        this._productList.removeEventListener('cart:add', this._addItemListener);
    }
    set categoryUri(uri) {
        this._categoryUri = uri;
    }
    loadProducts() {
        const products = this._categoryUri
            ? catalogService.productsFromCategory(this._categoryUri)
            : catalogService.products();        
        products
            .then(p => this._productList.products = p)
            .then(p => p.map(({id}) => id))
            .then(pIds => warehouseService.inStock(pIds))
            .then(s => this._productList.stock = s);
    }
    _addItemIntoCart(item) {
        return cartService.addItem(item)
            .then(window.dispatchEvent(new CustomEvent('cart:added', {detail: {...item}})));
    }
});