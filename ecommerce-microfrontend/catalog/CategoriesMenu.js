customElements.define('catalog-categories-menu', class extends HTMLElement {
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
        <nav class="categories">
            <a href="/" class="home">&#127968;</a>
            ${categories.map(category => `
                <a href="/category/${category.uri}">${category.title}</a>
            `).join('')}
        </nav>
        `;
    }
});
