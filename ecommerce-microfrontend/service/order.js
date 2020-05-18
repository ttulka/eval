export default {
    place: (orderId, items, total) =>
        Promise.resolve(console.log('Placing order', orderId, items, total))
}
