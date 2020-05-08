customElements.define('delivery-delivery-form', class extends HTMLElement {
    constructor() {
        super();
        this.prepareDelivery = (orderId, name, address) => 
            console.log('Preparing delivery', orderId, name, address);
    }
    connectedCallback() {
        this.render(this.html());
        
        this.submitForm = e => this.prepareDelivery(
            e.detail.orderId,
            this.querySelector('input[name=name]').value,
            this.querySelector('input[name=address]').value
        );
        this.addEventListener('order:placed', this.submitForm); 
    } 
    disconnectedCallback() {
        this.removeEventListener('submit', this.submitForm);
    }
    render(html) {
        this.innerHTML = html;
    }
    html() {
        return `
        <form action="/order" method="post" class="delivery-form">
            <table>
                <tr>
                    <td>Name</td>
                    <td><input name="name" size="30"></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input name="address" size="50"></td>
                </tr>
            </table>
        </form>
        `;
    }
});
