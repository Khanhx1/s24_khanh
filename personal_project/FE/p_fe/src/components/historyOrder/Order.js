import * as CartCourseService from "../../services/CartCourseService"
import {useEffect, useState} from "react";


export function Order() {
    const [bills, setBills] = useState([]);


    useEffect(() => {
        getBill();
    }, []);
    const getBill = async () => {
        try {
            const res = await CartCourseService.getBill();
            if (res) {
                setBills(res);
            }
        } catch (e) {
            console.log(e);
        }
    }

    return(
        <>




            <div className="row kus">
                <table className="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">code</th>
                        <th scope="col">Course</th>
                        <th scope="col">Date</th>
                        <th scope="col">Price</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        bills.map((item, index) => (
                            <tr key={item.id}>
                                <td>{index + 1}</td>
                                <td>{item.receipt.code}</td>
                                <td>{item.course.name}</td>
                                <td>{item.receipt.date}</td>
                                <td>{item.course.price}$</td>
                            </tr>
                        ))
                    }

                    </tbody>
                </table>
            </div>


        </>
    )
}