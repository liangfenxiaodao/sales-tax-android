package com.jackyli.salestax.data.products.repository

import com.jackyli.salestax.data.RestfulAPI
import com.jackyli.salestax.data.products.model.Products
import com.jackyli.salestax.testhelper.FakeObjectProvider
import com.jackyli.salestax.testhelper.RxImmediateSchedulerRule
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(RestfulAPI::class)
class ProductsRepositoryTest {
  @Rule
  @JvmField
  var testSchedulerRule = RxImmediateSchedulerRule()

  private lateinit var productsRepository: ProductsRepository

  @Mock
  lateinit var restfulAPI: RestfulAPI

  lateinit var products: Products

  @Before
  fun setUp() {
    products = FakeObjectProvider.fromJson<Products>("products.json")
    `when`(restfulAPI.getProducts()).thenReturn(Single.just(products))
    productsRepository = ProductsRepository(restfulAPI)
  }

  @Test
  fun `getProducts should return observable`() {
    val observer = TestObserver<Products>()

    productsRepository.getProducts().subscribe(observer)
    assertThat(observer.valueCount(), `is`(1))

    val product = observer.values()[0].products!![0]
    with(product) {
      assertThat(id, `is`("1"))
      assertThat(name, `is`("book"))
      assertThat(price, `is`("12.49"))
    }
  }
}
