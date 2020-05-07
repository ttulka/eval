import '../cart/BuyButton.js';

export default class ProductList extends HTMLElement {
    constructor() {
        super();
    }
    connectedCallback() {
        const products = fetch('/data/catalog/products.json')
            .then(b => b.json());
        const stock = fetch('/data/warehouse/stock.json')
            .then(b => b.json());
        Promise.all([products, stock])
            .catch(e => console.error('Cannot fetch data', e))
            .then(([p, s]) => this.render(this.html(p, s)));
    }
    render(html) {
        this.innerHTML = html;
    }
    html(products, stock) {
        const formatter = new Intl.NumberFormat('en-US', {
            style: 'currency',
            currency: 'USD',
        });
        const inStock = stock.reduce((a, {productId, inStock}) => {
            a[productId] = inStock;
            return a;
        }, []);
        
        return `
        <h1>Product Catalog</h1>

        <table class="products" cellpadding="10" cellspacing="0" border="0">
            ${products.map(product => `
                <tr class="product">
                    <th>${product.title}</th>
                    <td>${product.description}</td>
                    <td class="stock">${inStock[product.id] > 0 ? inStock[product.id] + ' left in stock' : 'sold out'}</td>
                    <td class="price">${formatter.format(product.price)}</td>
                    <td><cart-buy-button 
                            productId="${product.id}" 
                            title="${product.title}" 
                            price="${product.price}">
                        </cart-buy-button>
                    </td>
                </tr>
            `).join('')}
        </table>
        `;
    }
}
customElements.define('catalog-product-list', ProductList);
