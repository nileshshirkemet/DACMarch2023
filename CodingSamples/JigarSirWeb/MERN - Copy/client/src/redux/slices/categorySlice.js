import { createSlice } from '@reduxjs/toolkit';

const initialState = [];

export const categorySlice =  createSlice({
    name: 'categorySlice',
    initialState,
    reducers: {
        addCategory: () => {},
        showCategory: () => {},
        deleteCategory: () => {},
    }
});

export const { addCategory } = categorySlice.actions

export default categorySlice.reducer