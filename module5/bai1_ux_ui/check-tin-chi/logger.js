import {TYPE_LOG, TYPE_WARN, TYPE_ERROR} from './constant.js';

function logger(log, type = TYPE_LOG){
    console[type](log);
}

export default logger;