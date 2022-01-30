import logger from './logger.js';
// import {
//     TYPE_LOG,
//     TYPE_WARN,
//     TYPE_ERROR
// } from './constant.js';

import * as constants from './constant.js';
console.log(constants);
logger('Hello', constants.TYPE_ERROR)



fetch(course)
    .then(res => res.text())
    .then(data => data.split(`<td colspan="2" class="title-item">`)[8])
    .then(data => data.split(`<td colspan="2" class="heightcell">`)[1])
    .then(data => data.split(`</div>`)[0].replace(/\s/g, ''))
    .then(data => {
        let length = data.length;
        return data[length-1];
    })
    .then(data => console.log(data))



    var course = window.location.href;


    var course = `https://mydtu.duytan.edu.vn/sites/index.aspx?p=home_classdetailsall&classid=171584&semesterid=76&yearid=74&status=0&timespanid=76`;