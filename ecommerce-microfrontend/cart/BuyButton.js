customElements.define('cart-buy-button', class extends HTMLElement {
    connectedCallback() {
        this.render(this.html(
            this.getAttribute('productId'),
            this.getAttribute('title'),
            this.getAttribute('price')
        ));
    }
    render(html) {
        this.innerHTML = html;
    }
    html(id, title, price) {
        return `
        <form action="/cart" method="post">
            <input name="productId" value="${id}" type="hidden">
            <input name="title" value="${title}" type="hidden">
            <input name="price" value="${price}" type="hidden">
            <input name="quantity" value="1" type="hidden">
    
            <button type="submit" name="">buy</button>
        </form>
        `;
    }
});
