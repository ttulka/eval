export default class DeliveryForm extends HTMLElement {
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
        <form action="/order" method="post" class="form">
            <table>
                <tr>
                    <td>Name</td>
                    <td><input name="name" size="30"></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input name="address" size="50"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit">Submit</button></td>
                </tr>
            </table>
        </form>
        `;
    }
}
customElements.define('delivery-delivery-form', DeliveryForm);
