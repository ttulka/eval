customElements.define('delivery-delivery-form', class extends HTMLElement {
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
            </table>
        </form>
        `;
    }
});
