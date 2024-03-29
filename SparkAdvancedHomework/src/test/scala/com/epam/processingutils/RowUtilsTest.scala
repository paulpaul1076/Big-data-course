package com.epam.processingutils

/**
 * Tests the RowExtensions class.
 */
class RowUtilsTest extends JUnitSuite {
  /**
   * Tests the extractValueString method, making sure that it returns a proper path.
   */
  @Test
  def extractValueStringTest(): Unit = {
    val row = Row("16 JANUARY", "16", "hashtag", "12345")
    val actualValueString = RowUtils.extractValueString(row)
    val expectedValueString = "/date=16 JANUARY/hour=16"
    Assert.assertEquals(expectedValueString, actualValueString)
  }
}
