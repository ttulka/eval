import '../cart/ItemList.js';

import cartService from '../service/cart.js';

const template = document.createElement('template');
template.innerHTML = `
    <h1>Shopping Cart</h1>
    <div class="cart">
        <cart-item-list></cart-item-list>
        <div class="order">
            <a href="/order">Place Order</a>
        </div>
    </div>
`;
customElements.define('portal-cart-page', class extends HTMLElement {
    constructor() {
        super();
        this._removeItemListener = ({detail: {productId}}) => this._removeItem(productId);
    }
    connectedCallback() {
        console.debug('Cart page initialized');        
        
        this.appendChild(template.content.cloneNode(true));         
        this._itemList = this.querySelector('cart-item-list');  

        this._itemList.addEventListener('cart:remove', this._removeItemListener);
                
        this._loadItems();
    }
    disconnectedCallback() {
        this._itemList.removeEventListener('cart:remove', this._removeItemListener);
    }
    _loadItems() {
        cartService.items()
            .then(i => this._itemList.items = i);
    }
    _removeItem(productId) {
        cartService.removeItem(productId)
            .then(_ => window.dispatchEvent(new CustomEvent('cart:removed', {detail: {productId}})));
    }
});