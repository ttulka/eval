export default class ItemList extends HTMLElement {
    constructor() {
        super();
    }
    connectedCallback() {
        fetch('/data/cart/items.json')
            .then(b => b.json())
            .then(d => this.render(this.html(d)));
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
                            <a href="/cart/remove?productId=${productId}">&#x2718;</a>
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
}
customElements.define('cart-item-list', ItemList);
