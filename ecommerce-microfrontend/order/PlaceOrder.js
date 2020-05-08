import '../delivery/DeliveryForm.js';

customElements.define('order-place-order', class extends HTMLElement {
    connectedCallback() {
        this.render(this.html());
    }
    render(html) {
        this.innerHTML = html;
    }
    html() {
        return `
        <h1>Place Order</h1>

        <div class="order">
            <form action="/order" method="post" class="form">

                <delivery-delivery-form></delivery-delivery-form>

                <p>
                    <button type="submit">Submit</button>
                </p>
            </form>
        </div>
        `;
    }
});
