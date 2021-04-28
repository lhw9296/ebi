<template>
    <div>
        <div>
            <PrdCat/>
        </div>
        <div>
            <PrdList/>
        </div>
    </div>
</template>

<script>
import PrdList from '../components/PrdList'
import PrdCat from '../components/PrdCat'

export default {
     name: 'ProductList',
     components: {
         PrdList,
         PrdCat
     }
     
}
</script>
<style>
    
</style>
