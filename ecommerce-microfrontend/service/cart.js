let state = [];

export default {
    items: () => Promise.resolve([...state]),
    
    addItem: ({productId, title, price, quantity}) => new Promise(resolve => {
	    const curr = state.find(i => productId === i.productId);
        if (curr) {
            curr.quantity += quantity;
        } else {
            state.push({productId, title, price, quantity});
        }
        resolve();
    }),

    removeItem: (productId) => Promise.resolve(
        state = state.reduce((a,c) => productId === c.productId ? a : [...a, c], [])),
    
    empty: () => Promise.resolve(state = []),
}