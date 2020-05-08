import '../delivery/DeliveryForm.js';

customElements.define('order-place-order', class extends HTMLElement {
    constructor() {
        super();
        this.orderId = Date.now();
        this.placeOrder = () => console.log('Placing order', this.orderId);
    }
    connectedCallback() {
        this.render(this.html());
        
        this.deliveryForm = this.querySelector('delivery-delivery-form');
        this.formSubmit = e => {
            this.placeOrder();
            this.deliveryForm.dispatchEvent(
                new CustomEvent('order:placed', {detail: {orderId: this.orderId}}));
            
            this.querySelector('.order').innerHTML = 'Order has been successfully created.';
            e.preventDefault();
        }
        this.form = this.querySelector('.order-form');
        this.form.addEventListener('submit', this.formSubmit);
    }
    disconnectedCallback() {
        this.form.removeEventListener('submit', this.formSubmit);
    }
    render(html) {
        this.innerHTML = html;
    }
    html() {
        return `
        <h1>Place Order</h1>

        <div class="order">

            <delivery-delivery-form></delivery-delivery-form>

            <form action="/order" method="post" class="order-form">
                <p>
                    <button type="submit">Submit</button>
                </p>
            </form>
        </div>
        `;
    }
});
