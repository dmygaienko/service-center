import { Request, Image, DetailComponent, Work } from "./index";

export class RequestDetails extends Request {

    images: Image[];
    components: DetailComponent[];
    works: Work[];
    comments: Comment[];
}