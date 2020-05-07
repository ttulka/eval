export default class MenuLink extends HTMLElement {
    constructor() {
        super();
    }
    connectedCallback() {
        fetch('/data/catalog/categories.json')
            .then(b => b.json())
            .then(c => this.render(this.html(c)));
    }
    render(html) {
        this.innerHTML = html;
    }
    html(categories) {
        return `
        <a href="/cart" class="cart">&#x1F6D2;</a>
        `;
    }
}
customElements.define('cart-menu-link', MenuLink);
