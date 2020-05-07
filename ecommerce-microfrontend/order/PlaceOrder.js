import '../delivery/DeliveryForm.js';

export default class PlaceOrder extends HTMLElement {
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
        <h1>Place Order</h1>

        <div class="order">

            <delivery-delivery-form></delivery-delivery-form>

        </div>
        `;
    }
}
customElements.define('order-place-order', PlaceOrder);
