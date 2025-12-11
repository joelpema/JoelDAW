import { Iresult } from "./iresult.interface";

export interface Iwelcome {
    page:        number;
    per_page:    number;
    total:       number;
    total_pages: number;
    results:     Iresult[];
}
