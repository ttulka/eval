export default class MenuLink extends HTMLElement {
    constructor() {
        super();
    }
    connectedCallback() {
        this.render(this.html());
    }
    render(html) {
        this.innerHTML = html;
    }
    html() {
        return `
        <a href="/cart" class="cart">&#x1F6D2;</a>
        `;
    }
}
customElements.define('cart-menu-link', MenuLink);
