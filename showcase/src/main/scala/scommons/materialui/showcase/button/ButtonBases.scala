package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.materialui.styles._
import scommons.react._

import scala.scalajs.js

object ButtonBases extends FunctionComponent[Unit] {
  
  private[button] val images = List(
    ("static/images/image-list/breakfast.jpg", "Breakfast", "40%"),
    ("static/images/image-list/burgers.jpg", "Burgers", "30%"),
    ("static/images/image-list/camera.jpg", "Camera", "30%")
  )
  
  private[button] val useStyles = makeStyles(theme => {
    val s = new Styles {
      val root = new Styles {
        val display = "flex"
        val flexWrap = "wrap"
        val minWidth = 300
        val width = "100%"
      }
      val image = js.Dynamic.literal(
        "position" -> "relative",
        "height" -> 200,
        theme.breakpoints.down("xs").asInstanceOf[String] -> {
          val s = new Styles {
            val width = "100% !important" // Overrides inline-style
            val height = 100
          }
          s
        },
        s"&:hover, &$$focusVisible" -> {
          val s = new Styles {
            val zIndex = 1
            val `& $imageBackdrop` = new Styles {
              val opacity = 0.15
            }
            val `& $imageMarked` = new Styles {
              val opacity = 0
            }
            val `& $imageTitle` = new Styles {
              val border = "4px solid currentColor"
            }
          }
          s
        }
      )
      val focusVisible = new Styles {}
      val imageButton = new Styles {
        val position = "absolute"
        val left = 0
        val right = 0
        val top = 0
        val bottom = 0
        val display = "flex"
        val alignItems = "center"
        val justifyContent = "center"
        val color = theme.palette.common.white
      }
      val imageSrc = new Styles {
        val position = "absolute"
        val left = 0
        val right = 0
        val top = 0
        val bottom = 0
        val backgroundSize = "cover"
        val backgroundPosition = "center 40%"
      }
      val imageBackdrop = new Styles {
        val position = "absolute"
        val left = 0
        val right = 0
        val top = 0
        val bottom = 0
        val backgroundColor = theme.palette.common.black
        val opacity = 0.4
        val transition = theme.transitions.create("opacity")
      }
      val imageTitle = new Styles {
        val position = "relative"
        val padding =
          s"${theme.spacing(2)}px ${theme.spacing(4)}px ${theme.spacing(1).asInstanceOf[Int] + 6}px"
      }
      val imageMarked = new Styles {
        val height = 3
        val width = 18
        val backgroundColor = theme.palette.common.white
        val position = "absolute"
        val bottom = -2
        val left = "calc(50% - 9px)"
        val transition = theme.transitions.create("opacity")
      }
    }
    s
  })
  
  protected def render(compProps: Props): ReactElement = {
    val classes = useStyles()
    
    <.div(^.className := styleOf(classes.root))(
      images.map { case (imageUrl, imageTitle, imageWidth) =>
        <.ButtonBase(
          ^.focusRipple := true,
          ^.key := imageTitle,
          ^.className := styleOf(classes.image),
          ^.focusVisibleClassName := styleOf(classes.focusVisible),
          ^.muiStyle := new Styles {
            val width = imageWidth
          }
        )(
          <.span(
            ^.className := styleOf(classes.imageSrc),
            ^.muiStyle := new Styles {
              val backgroundImage = s"url($imageUrl)"
            }
          )(),
          <.span(^.className := styleOf(classes.imageBackdrop))(),
          <.span(^.className := styleOf(classes.imageButton))(
            <.Typography(
              ^.component := "span",
              ^.variant := "subtitle1",
              ^.color := "inherit",
              ^.className := styleOf(classes.imageTitle)
            )(
              imageTitle,
              <.span(^.className := styleOf(classes.imageMarked))()
            )
          )
        )
      }
    )
  }
}
