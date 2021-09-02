package scommons.reactdocgen

import scommons.nodejs.test.TestSpec

import scala.scalajs.js.JavaScriptException

class ReactDocgenSpec extends TestSpec {

  it should "fail if no component definition when parse" in {
    //given
    
    //when
    val ex = the[JavaScriptException] thrownBy {
      ReactDocgen.parse("", new ReactDocgenOptions {
        override val filename: String = "test.js"
      })
    }
    
    //then
    ex.getMessage() shouldBe "Error: No suitable component definition found."
  }
  
  it should "return empty displayName and props if none when parse" in {
    //when
    val result = ReactDocgen.parse(
      """import * as React from 'react';
        |import PropTypes from 'prop-types';
        |
        |export default () => {
        |  return (
        |    <div/>
        |  );
        |};
        |""".stripMargin, new ReactDocgenOptions {
      override val filename: String = "path/to/test_component.js"
    })
    
    //then
    result shouldBe ReactDocgenResult(
      description = "",
      displayName = None,
      props = Nil
    )
  }
  
  it should "return parsed info when parse" in {
    //when
    val result = ReactDocgen.parse(exampleComponentSource, new ReactDocgenOptions {
      override val filename: String = "path/to/test_component.js"
    })
    
    //then
    result shouldBe ReactDocgenResult(
      description = "",
      displayName = Some("Accordion"),
      props = List(
        ReactDocgenProp(
          name = "children",
          `type` = ReactDocgenType.Any,
          required = false,
          description = "The content of the component."
        ),
        ReactDocgenProp(
          name = "classes",
          `type` = ReactDocgenType.Obj,
          required = false,
          description = "Override or extend the styles applied to the component."
        ),
        ReactDocgenProp(
          name = "className",
          `type` = ReactDocgenType.Str,
          required = false,
          description = "@ignore"
        ),
        ReactDocgenProp(
          name = "testUnion",
          `type` = ReactDocgenType.Union(ReactDocgenType.Num, ReactDocgenType.Str),
          required = false,
          description = "Test union"
        ),
        ReactDocgenProp(
          name = "defaultExpanded",
          `type` = ReactDocgenType.Bool,
          required = false,
          description =
            """If `true`, expands the accordion by default.
              |@default false""".stripMargin
        ),
        ReactDocgenProp(
          name = "onChange",
          `type` = ReactDocgenType.Func,
          required = true,
          description =
            """Callback fired when the expand/collapse state is changed.
              |
              |@param {React.SyntheticEvent} event The event source of the callback. **Warning**: This is a generic event not a change event.
              |@param {boolean} expanded The `expanded` state of the accordion.""".stripMargin
        ),
        ReactDocgenProp(
          name = "TransitionComponent",
          `type` = ReactDocgenType.Any,
          required = false,
          description =
            """The component used for the transition.
              |[Follow this guide](/components/transitions/#transitioncomponent-prop) to learn more about the requirements for this component.
              |@default Collapse""".stripMargin
        )
      )
    )
  }
  
  private lazy val exampleComponentSource =
    """import * as React from 'react';
      |import { isFragment } from 'react-is';
      |import PropTypes from 'prop-types';
      |import clsx from 'clsx';
      |import { chainPropTypes } from '@material-ui/utils';
      |import { unstable_composeClasses as composeClasses } from '@material-ui/unstyled';
      |import styled from '../styles/styled';
      |import useThemeProps from '../styles/useThemeProps';
      |import Collapse from '../Collapse';
      |import Paper from '../Paper';
      |import AccordionContext from './AccordionContext';
      |import useControlled from '../utils/useControlled';
      |import accordionClasses, { getAccordionUtilityClass } from './accordionClasses';
      |
      |const useUtilityClasses = (ownerState) => {
      |  const { classes, square, expanded, disabled, disableGutters } = ownerState;
      |
      |  const slots = {
      |    root: [
      |      'root',
      |      !square && 'rounded',
      |      expanded && 'expanded',
      |      disabled && 'disabled',
      |      !disableGutters && 'gutters',
      |    ],
      |    region: ['region'],
      |  };
      |
      |  return composeClasses(slots, getAccordionUtilityClass, classes);
      |};
      |
      |const AccordionRoot = styled(Paper, {
      |  name: 'MuiAccordion',
      |  slot: 'Root',
      |  overridesResolver: (props, styles) => {
      |    const { ownerState } = props;
      |
      |    return [
      |      styles.root,
      |      !ownerState.square && styles.rounded,
      |      !ownerState.disableGutters && styles.gutters,
      |    ];
      |  },
      |})(
      |  ({ theme }) => {
      |    const transition = {
      |      duration: theme.transitions.duration.shortest,
      |    };
      |
      |    return {
      |      position: 'relative',
      |      transition: theme.transitions.create(['margin'], transition),
      |      overflowAnchor: 'none', // Keep the same scrolling position
      |      '&:before': {
      |        position: 'absolute',
      |        left: 0,
      |        top: -1,
      |        right: 0,
      |        height: 1,
      |        content: '""',
      |        opacity: 1,
      |        backgroundColor: theme.palette.divider,
      |        transition: theme.transitions.create(['opacity', 'background-color'], transition),
      |      },
      |      '&:first-of-type': {
      |        '&:before': {
      |          display: 'none',
      |        },
      |      },
      |      ['&:expanded']: {
      |        '&:before': {
      |          opacity: 0,
      |        },
      |        '&:first-of-type': {
      |          marginTop: 0,
      |        },
      |        '&:last-of-type': {
      |          marginBottom: 0,
      |        },
      |        '& + &': {
      |          '&:before': {
      |            display: 'none',
      |          },
      |        },
      |      },
      |      ['&:disabled']: {
      |        backgroundColor: theme.palette.action.disabledBackground,
      |      },
      |    };
      |  },
      |  ({ theme, ownerState }) => ({
      |    ...(!ownerState.square && {
      |      borderRadius: 0,
      |      '&:first-of-type': {
      |        borderTopLeftRadius: theme.shape.borderRadius,
      |        borderTopRightRadius: theme.shape.borderRadius,
      |      },
      |      '&:last-of-type': {
      |        borderBottomLeftRadius: theme.shape.borderRadius,
      |        borderBottomRightRadius: theme.shape.borderRadius,
      |        // Fix a rendering issue on Edge
      |        '@supports (-ms-ime-align: auto)': {
      |          borderBottomLeftRadius: 0,
      |          borderBottomRightRadius: 0,
      |        },
      |      },
      |    }),
      |    ...(!ownerState.disableGutters && {
      |      ['&:expanded']: {
      |        margin: '16px 0',
      |      },
      |    }),
      |  }),
      |);
      |
      |const Accordion = React.forwardRef(function Accordion(inProps, ref) {
      |  const props = useThemeProps({ props: inProps, name: 'MuiAccordion' });
      |  const {
      |    children: childrenProp,
      |    className,
      |    defaultExpanded = false,
      |    disabled = false,
      |    disableGutters = false,
      |    expanded: expandedProp,
      |    onChange,
      |    square = false,
      |    TransitionComponent = Collapse,
      |    TransitionProps,
      |    ...other
      |  } = props;
      |
      |  const [expanded, setExpandedState] = useControlled({
      |    controlled: expandedProp,
      |    default: defaultExpanded,
      |    name: 'Accordion',
      |    state: 'expanded',
      |  });
      |
      |  const handleChange = React.useCallback(
      |    (event) => {
      |      setExpandedState(!expanded);
      |
      |      if (onChange) {
      |        onChange(event, !expanded);
      |      }
      |    },
      |    [expanded, onChange, setExpandedState],
      |  );
      |
      |  const [summary, ...children] = React.Children.toArray(childrenProp);
      |  const contextValue = React.useMemo(
      |    () => ({ expanded, disabled, disableGutters, toggle: handleChange }),
      |    [expanded, disabled, disableGutters, handleChange],
      |  );
      |
      |  const ownerState = {
      |    ...props,
      |    square,
      |    disabled,
      |    disableGutters,
      |    expanded,
      |  };
      |
      |  const classes = useUtilityClasses(ownerState);
      |
      |  return (
      |    <AccordionRoot
      |      className={clsx(classes.root, className)}
      |      ref={ref}
      |      ownerState={ownerState}
      |      square={square}
      |      {...other}
      |    >
      |      <AccordionContext.Provider value={contextValue}>{summary}</AccordionContext.Provider>
      |      <TransitionComponent in={expanded} timeout="auto" {...TransitionProps}>
      |        <div
      |          aria-labelledby={summary.props.id}
      |          id={summary.props['aria-controls']}
      |          role="region"
      |          className={classes.region}
      |        >
      |          {children}
      |        </div>
      |      </TransitionComponent>
      |    </AccordionRoot>
      |  );
      |});
      |
      |Accordion.propTypes /* remove-proptypes */ = {
      |  // ----------------------------- Warning --------------------------------
      |  // | These PropTypes are generated from the TypeScript type definitions |
      |  // |     To update them edit the d.ts file and run "yarn proptypes"     |
      |  // ----------------------------------------------------------------------
      |  /**
      |   * The content of the component.
      |   */
      |  children: chainPropTypes(PropTypes.node.isRequired, (props) => {
      |    const summary = React.Children.toArray(props.children)[0];
      |    if (isFragment(summary)) {
      |      return new Error(
      |        "Material-UI: The Accordion doesn't accept a Fragment as a child. " +
      |          'Consider providing an array instead.',
      |      );
      |    }
      |
      |    if (!React.isValidElement(summary)) {
      |      return new Error('Material-UI: Expected the first child of Accordion to be a valid element.');
      |    }
      |
      |    return null;
      |  }),
      |  /**
      |   * Override or extend the styles applied to the component.
      |   */
      |  classes: PropTypes.object,
      |  /**
      |   * @ignore
      |   */
      |  className: PropTypes.string,
      |  /**
      |   * Test union
      |   */
      |  testUnion: PropTypes.oneOfType([PropTypes.number, PropTypes.string]),
      |  /**
      |   * If `true`, expands the accordion by default.
      |   * @default false
      |   */
      |  defaultExpanded: PropTypes.bool,
      |  /**
      |   * Callback fired when the expand/collapse state is changed.
      |   *
      |   * @param {React.SyntheticEvent} event The event source of the callback. **Warning**: This is a generic event not a change event.
      |   * @param {boolean} expanded The `expanded` state of the accordion.
      |   */
      |  onChange: PropTypes.func.isRequired,
      |  /**
      |   * The component used for the transition.
      |   * [Follow this guide](/components/transitions/#transitioncomponent-prop) to learn more about the requirements for this component.
      |   * @default Collapse
      |   */
      |  TransitionComponent: PropTypes.elementType,
      |};
      |
      |export default Accordion;
      |""".stripMargin
}
