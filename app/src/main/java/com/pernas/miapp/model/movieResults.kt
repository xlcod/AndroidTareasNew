package com.pernas.miapp.model

data class movieResults (

     val results: List<MovieDataClass>
) : List<MovieDataClass> {
    override val size: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun contains(element: MovieDataClass): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun containsAll(elements: Collection<MovieDataClass>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(index: Int): MovieDataClass {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun indexOf(element: MovieDataClass): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isEmpty(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun iterator(): Iterator<MovieDataClass> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun lastIndexOf(element: MovieDataClass): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun listIterator(): ListIterator<MovieDataClass> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun listIterator(index: Int): ListIterator<MovieDataClass> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<MovieDataClass> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

data class MoviesDetailReponse(
    val moviesDetailResponse: List<MovieDetail>
)



data class MovieDetail(
    val title: String,
    val vote_average: String,
    val overview: String,
    val release_Date: String

)
