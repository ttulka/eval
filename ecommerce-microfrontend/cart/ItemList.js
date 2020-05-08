customElements.define('cart-item-list', class extends HTMLElement {
    constructor() {
        super();
        this.removeFromCart = productId => console.log('Removing from cart', productId);
        this._listeners = [];
    }
    connectedCallback() {
        fetch('/data/cart/items.json')
            .then(b => b.json())
            .then(d => this.render(this.html(d)))
            .then(_ => this.querySelectorAll('.cart-remove').forEach(el => {
                const l = e => this.removeFromCart(e.target.getAttribute('productId'));
                el.addEventListener('click', l);
                this._listeners.push({el, l});
            }));
    }
    disconnectedCallback() {
        this._listeners.forEach(({el, l}) => el.removeEventListener('click', l));
    }
    render(html) {
        this.innerHTML = html;
    }
    html(items) {
        const formatter = new Intl.NumberFormat('en-US', {
            style: 'currency',
            currency: 'USD',
        });
        
        return `
        <h1>Shopping Cart</h1>

        <div class="cart">

            <table cellpadding="10" cellspacing="0" border="0">
                ${items.map(({productId, title, price, quantity}) => `
                    <tr class="item">
                        <td class="title">${title}</td>
                        <td class="price">${formatter.format(price)}</td>
                        <td class="quantity">${quantity}</td>
                        <td class="remove">
                            <a href="/cart" class="cart-remove" productId="${productId}">&#x2718;</a>
                        </td>
                    </tr>
                `).join('')}
            </table>

            <div class="order">
                <a href="/order">Place Order</a>
            </div>
        </div>
        `;
    }
});
