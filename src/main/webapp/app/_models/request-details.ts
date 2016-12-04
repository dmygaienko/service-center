import { Request, Image, Component, Work } from "./index";

export class RequestDetails extends Request {

    images: Image[];
    components: Component[];
    works: Work[];
    comments: Comment[];
}