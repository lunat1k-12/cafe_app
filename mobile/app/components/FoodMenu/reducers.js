
export const food = (state = [], action) => {
    switch (action.type) {
        case 'FOOD_MENU_LOADED':
            return action.food;
        default:
            return state
    }
}