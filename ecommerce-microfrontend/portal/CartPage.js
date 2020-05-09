import '../cart/ItemList.js';

import cart from '../service/cart.js';

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
    connectedCallback() {
        console.debug('Cart page initialized');        
        
        this.appendChild(template.content.cloneNode(true));         
        this._itemList = this.querySelector('cart-item-list');  
                
        cart.items()
            .then(i => this._itemList.items = i);
    }
});