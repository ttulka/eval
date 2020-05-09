const template = document.createElement('template');
template.innerHTML = `
    <form action="#" method="post" class="delivery-form">
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
customElements.define('delivery-form', class extends HTMLElement {
    constructor() {
        super();
        this._formSubmitListener = e => e.preventDefault();
    }
    connectedCallback() {
        this.appendChild(template.content.cloneNode(true));
        
        this._formEl = this.querySelector('form');
        this._nameInp = this._formEl.querySelector('input[name=name]');
        this._addressInp = this._formEl.querySelector('input[name=address]');
        
        this._formEl.addEventListener('submit', this._formSubmitListener);
    } 
    disconnectedCallback() {
        this._formEl.removeEventListener('submit', this._formSubmitListener);
    }
    isValid() {
        return this._nameInp.value && this._nameInp.value.trim() &&
            this._addressInp.value && this._addressInp.value.trim();
    }
    markAsInvalid() {
        console.log('delivery form marked as invalid');
    }
    submit() {
        const name = this._nameInp.value;
        const address = this._addressInp.value;
        
        this.dispatchEvent(new CustomEvent('delivery:prepare', {detail: {name, address}}));
    }
});
