package controllers

import javax.inject.Inject

import play.api.Configuration
import play.api.mvc.Controller


class StaticWebJarAssets @Inject() (webJarAssets: WebJarAssets, configuration: Configuration) extends Controller {

  // prepends a url if the assets.url config is set
  def url(file: String): String = {
    val baseUrl = routes.WebJarAssets.at(file).url
    configuration.getString("assets.url").fold(baseUrl)(_ + baseUrl)
  }

  def locateUrl(path: String): String = {
    url(webJarAssets.locate(path))
  }

}