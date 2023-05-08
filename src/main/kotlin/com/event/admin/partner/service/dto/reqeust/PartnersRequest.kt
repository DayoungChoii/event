package com.event.admin.partner.service.dto.reqeust

import java.awt.print.PageFormat
import java.awt.print.Pageable
import java.awt.print.Printable

class PartnersRequest constructor(): Pageable
{
    override fun getNumberOfPages(): Int {
        TODO("Not yet implemented")
    }

    override fun getPageFormat(pageIndex: Int): PageFormat {
        TODO("Not yet implemented")
    }

    override fun getPrintable(pageIndex: Int): Printable {
        TODO("Not yet implemented")
    }

}
