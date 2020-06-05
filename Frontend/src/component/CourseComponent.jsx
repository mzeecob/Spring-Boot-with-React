import React, { Component } from "react"
import { Formik, Form, Field, ErrorMessage } from 'formik';
import CourseDataService from '../service/CourseDataService';


class CourseComponent extends Component{

    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            description: ''
        }
        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)
    }

    componentDidMount() {
        // eslint-disable-next-line
        if (this.state.id == -1) {
            return
        }
        CourseDataService.retrieveCourse(this.state.id)
        .then(
            response => {
                this.setState({ description: response.data.description })
            }
        ) 
    }

    onSubmit(values) {
        let course = {
            id: this.state.id,
            description: values.description,
            targetDate: values.targetDate
        }

        if (this.state.id === -1) {
            CourseDataService.createCourse(course)
                .then(() => this.props.history.push('/courses'))
        } else {
            CourseDataService.updateCourse(this.state.id, course)
                .then(() => this.props.history.push('/courses'))
        }
    }

    validate(values) {
        let errors = {}
        if (!values.description) {
            errors.description = 'Enter a Description'
        } else if (values.description.length < 5) {
            errors.description = 'Enter atleast 5 Characters in Description'
        }
    
        return errors
    }

    

    render() {
        let { description, id } = this.state
        return (
            <div>
               
                <h3>Course</h3>
                <div className="container">
                    <Formik
                        initialValues={{ description, id }}
                        onSubmit={this.onSubmit}
                        validateOnChange={false}
                        validateOnBlur={false}
                        validate={this.validate}
                        enableReinitialize={true}
                    >
                        {
                            (props) => (
                                <Form>

                                    <ErrorMessage name="description" component="div"
                                        className="alert alert-warning" />

                                    <fieldset className="form-group">
                                        <label>Id</label>
                                        <Field className="form-control" type="text" name="id" disabled />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Description</label>
                                        <Field className="form-control" type="text" name="description"/>
                                    </fieldset>
                                    <button className="btn btn-success" type="submit">Save</button>
                                </Form>
                            )
                        }
                    </Formik>

                </div>
            </div>
            
        )
    }
}

export default CourseComponent