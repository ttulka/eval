customElements.define('cart-buy-button', class extends HTMLElement {
    constructor() {
        super();
        this.addIntoCart = (productId, title, price, quantity) => 
            console.log('Adding into cart', productId, title, price, quantity);
    }
    connectedCallback() {
        this.render(this.html());
        
        this.button = this.querySelector('.cart-buy');
        this.buttonClick = e => this.addIntoCart(
            this.getAttribute('productId'),
            this.getAttribute('title'),
            this.getAttribute('price'),
            1
        );
        this.button.addEventListener('click', this.buttonClick);

    }
    disconnectedCallback() {
        this.button.removeEventListener('click', this.buttonClick);
    }
    render(html) {
        this.innerHTML = html;
    }
    html() {
        return `
        <a href="/cart" class="cart-buy">buy</a>
        `;
    }
});
