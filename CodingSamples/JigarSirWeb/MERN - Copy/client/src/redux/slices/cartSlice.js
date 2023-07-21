import { createSlice } from '@reduxjs/toolkit'

const initialState = [];

export const cartSlice =  createSlice({
    name: 'cartslice',
    initialState,
    reducers: {
        addToCart:( state , action)=>{
            console.log('add cart called');
            // console.log(state);
            // console.log(action);
            console.log(action.payload);
            state.push(action.payload);
        },
        removeFromCart:(state,action)=>{
            // console.log('remove called');
            // console.log(action.payload);
            var ans = state.filter(obj=> obj._id!==action.payload._id);
            console.log(ans);
            return ans;
        }
    }
});

export const { addToCart, removeFromCart } = cartSlice.actions;
export default cartSlice.reducer;