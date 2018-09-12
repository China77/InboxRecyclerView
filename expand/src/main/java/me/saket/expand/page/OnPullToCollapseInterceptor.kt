package me.saket.expand.page

interface OnPullToCollapseInterceptor {

  /**
   * Called once every time a vertical scroll gesture is registered on [ExpandablePageLayout].
   * When intercepted, all touch events until the finger is lifted will be ignored. This is
   * useful when nested (vertically) scrollable layouts are also present inside the page.
   *
   * Example usage:
   *
   * ```
   * val directionInt = if (upwardPull) +1 else -1
   * val canScrollFurther = scrollableChild.canScrollVertically(directionInt)
   * return if (canScrollFurther) InterceptResult.INTERCEPTED else InterceptResult.IGNORED
   * ```
   *
   * @param downX      X-coordinate from where the gesture started, relative to the screen window.
   * @param downY      Y-coordinate from where the gesture started, relative to the screen window.
   * @param upwardPull Upward pull == downward scroll and vice versa.
   *
   * @return True to consume this touch event. False otherwise.
   */
  fun onIntercept(downX: Float, downY: Float, upwardPull: Boolean): InterceptResult

  class IgnoreAll : OnPullToCollapseInterceptor {
    override fun onIntercept(downX: Float, downY: Float, upwardPull: Boolean) = InterceptResult.IGNORED
  }
}
