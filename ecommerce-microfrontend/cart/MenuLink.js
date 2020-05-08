customElements.define('cart-menu-link', class extends HTMLElement {
    connectedCallback() {
        this.render(this.html());
    }
    render(html) {
        this.innerHTML = html;
    }
    html() {
        return `
        <a href="/cart.html" class="cart">&#x1F6D2;</a>
        `;
    }
});
